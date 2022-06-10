#!/bin/bash

# Check if docfx is installed
if ! [ -x "$(command -v docfx)" ]; then
  echo 'Error: docfx is not installed' >&2
  echo 'You can install it with `brew install docfx` or from https://github.com/dotnet/docfx/' >&2
  exit 1
fi

echo `dirname "$0"`
SCRIPT_DIR="`pwd`/`dirname "$0"`"
DOCFX_PROJ_PATH=${SCRIPT_DIR%"/."}
DOCFX_PROJ_PATH=${DOCFX_PROJ_PATH%"/build"}
DEFAULT_SCICHART_PATH="$DOCFX_PROJ_PATH/../SciChart.Dev/Android/src/Examples/"

usage() {
cat <<EOF
Usage: sh $0 command [argument(s)]

command:
  generate-api-docs <scichart_android_path> :  generates api documentation from SciChart.Android JavaDoc comments.
  generate-site                             :  generates full documentation site from \`.md\` articles and \`.yaml\` api docs metadata.
  build <scichart_android_path>             :  build full documentation from \`.md\` articles and SciChart.Android JavaDoc comments.
  serve                                     :  builds and serves site to \`localhost\` from \`.md\` articles and prepared \`.yaml\` api docs metadata.
params:
  <scichart_android_path>                   :  if there's no path provided, the default one will be used - \`${DEFAULT_SCICHART_PATH}\`

EOF
}

generate_api_docs() {
    SCICHART_PATH=${1:-$DEFAULT_SCICHART_PATH}
    if [[ $SCICHART_PATH != /* ]]; then
        # if path is relative - prepend `pwd`
        SCICHART_PATH=$PWD/$SCICHART_PATH  
    fi

    if [ ! -d $SCICHART_PATH ]; then
        echo "Directory $SCICHART_PATH DOES NOT exists." >&2
        exit 1
    fi

    echo " ----- Generating \`.yaml\` API files from SciChart.Android JavaDoc comments..."
    pushd $SCICHART_PATH
    sh gradlew generateReleaseApiDocs -PDOCFX_PROJ_PATH=${DOCFX_PROJ_PATH}
    returnCode=$?
    popd

    # check return code of generateReleaseApiDocs command and prevent further execution if it failed
    if [ $returnCode -ne 0 ]; then
        exit $returnCode
    fi    
}

generate_site() {
    echo " ----- Generating static website combining API in YAML files and zarticles..."
    docfx build $DOCFX_PROJ_PATH/docfx.json
}

build() {
    generate_api_docs $1
    generate_site
}

serve() {
    echo " ----- Prepare hosting a local static documentation website..."
    docfx $DOCFX_PROJ_PATH/docfx.json --serve
}

# Read and select command to execute
COMMAND=$1

case $COMMAND in
    "generate-api-docs")
        generate_api_docs $2
        exit 0
        ;;

    "generate-site")
        generate_site
        exit 0
        ;;

    "build")
        build $2
        exit 0
        ;;

    "serve")
        serve
        exit 0
        ;;
        
    *)
        echo "ERROR: Unknown command '$COMMAND'"
        usage
        exit 1
        ;;
esac