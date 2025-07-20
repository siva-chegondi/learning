# Running this script will
# up the kind cluster using the config
# and will install kong ingress controller

# Help function to display usage
help() {
    echo "Usage: $0 -[f|a|i|h]"
    exit 1
}

# Install statics if parameter is true
function deploy_static_websites() {
    # loading the images to run the statics
    kind load docker-image jokrhat finhamper swaggerapi/swagger-editor:next-v5 -n local

    # installing the helm statics chart
    helm install statics ./statics
}

function install_api_services() {
    # load images for services to run on k8s kind cluster
    kind load docker-image payment:local gauth:local proximity:local -n local

    # installing the helm services chart
    helm upgrade --install services ./services
}

function install_local_cluster() {
    echo "Installing base cluster"
    kind create cluster --config conf.yml

    # install CRDs for gateway and gateway class
    kubectl --context kind-local apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.3.0/standard-install.yaml

    # installing the infra chart
    ./infra/setup.sh
}

# Parse named arguments
while getopts ':haifk' option; do
    case $option in
        i)
          install_local_cluster
          ;;
        f)
          echo "deploying frontend websites"
          deploy_static_websites
          ;;
        a)
          echo "deploying API k8s services"
          install_api_services
          ;;
        h)
          help
          ;;
        k)
          echo "Destroying the local cluster"
          kind delete cluster -n local
          ;;
        \?)
          echo "Error: Unknown parameter: $1"
          help
          exit;;
    esac
done