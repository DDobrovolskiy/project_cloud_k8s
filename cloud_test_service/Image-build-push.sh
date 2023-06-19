docker rmi ddobrovolskiy/cloud-test:0.0.3
docker image build . -t ddobrovolskiy/cloud-test:0.0.3
minikube image load ddobrovolskiy/cloud-test:0.0.3
docker push ddobrovolskiy/cloud-test:0.0.3