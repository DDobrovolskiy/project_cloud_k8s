docker rmi ddobrovolskiy/cloud-facade:0.0.2
docker image build . -t ddobrovolskiy/cloud-facade:0.0.2
minikube image load ddobrovolskiy/cloud-facade:0.0.2
docker push ddobrovolskiy/cloud-facade:0.0.2