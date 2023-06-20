docker rmi ddobrovolskiy/cloud-test:0.0.4
docker image build . -t ddobrovolskiy/cloud-test:0.0.4
minikube image load ddobrovolskiy/cloud-test:0.0.4
docker push ddobrovolskiy/cloud-test:0.0.4