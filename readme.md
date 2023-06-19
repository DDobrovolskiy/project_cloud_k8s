### Planned:
![Microsoft Visio Drawing](https://github.com/DDobrovolskiy/project_cloud_k8s/assets/65667662/601698eb-d20b-4a87-a1f2-add974d5d469)

### Ready:
- [x] Project scheme;

### Настройка minikube:
- https://tproger.ru/articles/kak-ustanovit-kubernetes-s-minikube-na-linux/  
Создадим неймспейс и установим его как текущий (не обязательно):
```shell
kubectl create namespace my-ns
kubectl config set-context --current --namespace=my-ns
```
Для тестов выведен сервис фасада, чтобы получить его урл:
```shell
minikube service facade-service-out -n my-ns
```
В результате получваем ответы с http://192.168.59.100:31130 и http://192.168.59.100:31130/test

DASHBOARD:
```shell
kubectl create namespace kubernetes-dashboard
```
### Create Secrets
```shell
echo -n 'root' | base64
#cm9vdA==
```

### Docker images
- docker image build . -t cloud-test:0.0.1
- docker image build . -t cloud-facade:0.0.1

### Helm
Установка:
- https://linux.how2shout.com/how-to-install-helm-on-ubuntu-22-04-lts-jammy/

### Link:
- Ссылка на настройку двух сервисов https://habr.com/ru/articles/487922/
- Kubernetes NodePort vs LoadBalancer vs Ingress? Когда и что использовать? https://habr.com/ru/companies/southbridge/articles/358824/
- https://max-ko.ru/75-ustanovka-minikube.html
- Создание пакетов для Kubernetes с Helm: структура чарта и шаблонизация https://habr.com/ru/companies/flant/articles/423239/
