docker rmi cloud-facade:0.0.1
docker image build . -t cloud-facade:0.0.1
minikube image load cloud-facade:0.0.1