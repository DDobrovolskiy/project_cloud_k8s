charts/ — в этой директории располагают вложенные чарты. Эта директория будет пуста, так как наша система не имеет зависимостей от других чартов.

Chart.yaml — файл со служебной информацией о чарте и приложении, который он разворачивает.

*templates/*.yaml* — файлы с шаблонами объектов Kuberenetes.

templates/NOTES.txt — содержит шаблон со справочной информацией, которая будет выведена пользователю при установке чарта.

*templates/tests/*.yaml* — файлы с шаблонами для тестов Helm.

templates/_helpers.tpl — файл со вспомогательными шаблонами, которые могут быть переиспользованы в чарте. Подобные файлы по соглашению должен начинаться с нижнего подчеркивания и иметь расширение tpl.

values.yaml — содержит свойства чарта с их дефолтными значениями.

values.schema.json — JSON-схема для валидации свойств из values.yaml.

Перед установкой Helm надо проверить его с помощью:
```shell
helm install --dry-run -f values.yaml  my-app .
```
Получим:
```shell
NAME: my-app
LAST DEPLOYED: Thu Jun 15 22:54:52 2023
NAMESPACE: default
STATUS: pending-install
REVISION: 1
TEST SUITE: None
HOOKS:
MANIFEST:
---
# Source: app-chart/templates/facade_service.yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: facade-config
data:
  SERVER_TEST_INSTANCE: "http://test-service:8080"
  SERVER_PORT: "8080"
---
# Source: app-chart/templates/test_service.yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: test-config
data:
  SERVER_PORT: "8080"
---
# Source: app-chart/templates/facade_service.yaml
apiVersion: v1
kind: Service
metadata:
  name: facade-service
  labels:
    environment: "dev"
    release: "stable"
    chart: app-chart-0.0.1
    app: facade-service
spec:
  type: ClusterIP
  ports:
    - name: http
      port: 8080        #выходной порт сервиса
      protocol: TCP
      targetPort: 8080  #порт облуживаемых подов http://facade-service:8080
  selector:
    environment: "dev"
    release: "stable"
    app: facade       #название приложения
---
# Source: app-chart/templates/facade_service.yaml
apiVersion: v1
kind: Service
metadata:
  name: facade-service-out
  labels:
    environment: "dev"
    release: "stable"
    chart: app-chart-0.0.1
    app: facade-service-out
spec:
  ports:
    - port: 80
      protocol: TCP
      targetPort: 8080
  selector:
    environment: "dev"
    release: "stable"
    app: facade       #название приложения
  type: NodePort
---
# Source: app-chart/templates/test_service.yaml
apiVersion: v1
kind: Service
metadata:
  name: test-service
  labels:
    environment: "dev"
    release: "stable"
    chart: app-chart-0.0.1
    app: test-service
spec:
  type: ClusterIP
  ports:
    - name: http
      port: 8080        #выходной порт сервиса
      protocol: TCP
      targetPort: 8080  #порт облуживаемых подов
  selector:
    environment: "dev"
    release: "stable"
    app: test   #название приложения
---
# Source: app-chart/templates/facade_service.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: facade      #название пода
  labels:
    environment: "dev"
    release: "stable"
    chart: app-chart-0.0.1
    app: facade
spec:
  replicas: 1             #количество реплик
  strategy:
    rollingUpdate:
      maxSurge: 100%
      maxUnavailable: 100%
    type: RollingUpdate
  selector:
    matchLabels:
      environment: "dev"
      release: "stable"
      chart: app-chart-0.0.1
      app: facade
  template:
    metadata:
      labels:
        environment: "dev"
        release: "stable"
        chart: app-chart-0.0.1
        app: facade
    spec:
      containers:
        - name: facade
          image: ddobrovolskiy/cloud-facade:0.0.1
          imagePullPolicy: IfNotPresent
          envFrom:
            - configMapRef:
                name: facade-config   #Ссылаемся на уже созданный ConfigMap
          ports:
            - containerPort: 8080
              protocol: TCP
#          readinessProbe:
#            httpGet:
#              path: /actuator/health
#              port: 8080
#            initialDelaySeconds: 5  #задежка перед первой проверкой
#            periodSeconds: 3        #интервал между проверками
#          resources:
#            limits:
#              memory: "256Mi"
#              cpu: "200m"
#            requests:
#              memory: "128Mi"
#              cpu: "50m"
---
# Source: app-chart/templates/test_service.yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: test      #название пода
  labels:
    environment: "dev"
    release: "stable"
    app: test   #название приложения
spec:
  replicas: 1             #количество реплик
  strategy:
    rollingUpdate:
      maxSurge: 100%
      maxUnavailable: 100%
    type: RollingUpdate
  selector:
    matchLabels:
      environment: "dev"
      release: "stable"
      app: test   #название приложения
  template:
    metadata:
      labels:
        environment: "dev"
        release: "stable"
        app: test   #название приложения
    spec:
      containers:
        - name: test
          image: ddobrovolskiy/cloud-test:0.0.1
          imagePullPolicy: IfNotPresent
          envFrom:
            - configMapRef:
                name: test-config  #Ссылаемся на уже созданный ConfigMap
          ports:
            - containerPort: 8080
              protocol: TCP
#          readinessProbe:
#            httpGet:
#              path: /actuator/health
#              port: 8080
#            initialDelaySeconds: 5  #задежка перед первой проверкой
#            periodSeconds: 3        #интервал между проверками
#          resources:
#            limits:
#              memory: "256Mi"
#              cpu: "200m"
#            requests:
#              memory: "128Mi"
#              cpu: "50m"

NOTES:
Hello world from Helm!
```
Список хелмов:
```shell
helm list
```
Для обновления хелма:
```shell
helm upgrade -i my-app .
```