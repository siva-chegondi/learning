# update helm with the kong repo
helm repo add kong https://charts.konghq.com
helm repo update

infra_base=$(dirname $0);
echo $infra_base;

# installing the kong ingress controller
helm install kong kong/ingress -f $infra_base/kong-values.yaml

# installing the helm chart
helm install infra $infra_base
