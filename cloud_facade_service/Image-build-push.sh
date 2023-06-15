#docker rmi ddobrovolskiy/cloud-facade:0.0.1
docker image build . -t ddobrovolskiy/cloud-facade:0.0.1
#minikube image load ddobrovolskiy/cloud-facade:0.0.1
docker push ddobrovolskiy/cloud-facade:0.0.1