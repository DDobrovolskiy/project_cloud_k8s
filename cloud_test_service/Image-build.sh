docker rmi cloud-test:0.0.1
docker image build . -t cloud-test:0.0.1
minikube image load cloud-test:0.0.1