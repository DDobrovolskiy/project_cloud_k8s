helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm install prometheus prometheus-community/prometheus
#Первая команда устанавливает диаграммы. Поскольку мы используем Minikube, вторая команда предоставляет prometheus-serverсервис с помощью файла NodePort. Таким образом, теперь мы можем легко получить доступ к веб-интерфейсу Prometheus, когда Pod готов:
kubectl expose service prometheus-server --type=NodePort --target-port=9090 --name=prometheus-server-np
#Посмотреть на прометей
#minikube service prometheus-server-np

#GRAFANA
helm repo add grafana https://grafana.github.io/helm-charts
helm repo update
helm install grafana grafana/grafana
kubectl expose service grafana --type=NodePort --target-port=3000 --name=grafana-np
kubectl get secret --namespace default grafana -o jsonpath="{.data.admin-password}" | base64 --decode ; echo
#admin
#mFVHWdeIfrqW39jFr1Ty7VEpM9Eh8FTRiBsXIL7y
#minikube service grafana-np