docker rmi ddobrovolskiy/cloud-test:0.0.1
docker image build . -t ddobrovolskiy/cloud-test:0.0.1
minikube image load ddobrovolskiy/cloud-test:0.0.1
docker push ddobrovolskiy/cloud-test:0.0.1