# Running this script will
# up the kind cluster using the config

kind create cluster --config conf.yml

# install CRDs for gateway and gateway class 
kubectl --context kind-local apply -f https://github.com/kubernetes-sigs/gateway-api/releases/download/v1.0.0/standard-install.yaml

# installing the infra chart
./infra/setup.sh

# uncomment the following line to 
# install the statics using this script

# loading the images to run the statics
kind load docker-image jokrhat finhamper swaggerapi/swagger-editor:next-v5 -n local

# installing the helm chart
helm install statics ./statics
