## Activité Pratique n°4 : e-store Microservices app.


-  Cette application avec une architecture Microservice en utilisant Spring Boot
-  Ce projet met en œuvre une architecture microservices avec des services dédiés à la gestion des commandes, à l'inventaire des produits, à la gestion des clients, ainsi qu'un service de passerelle (Gateway) qui assure la decouverte dynamique des microservice.
-  L'application contient les services suivants : customer, order, inventory, gatewaye et un config service.
-   Chaque service est conçu pour fonctionner de manière indépendante, améliorant la flexibilité et la scalabilité du système.

#### 0 - Project Hierarchy

- Initialisation des microservices avec les dependances necessaires: Spring JPA, Actuator, Consul Discovery, REST Repository, Config Client..etc

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/rep-micro.png)!

#### 1 - Consul Discovery
- Pour assurer le discovery avec **Consul**, on a activé le serveur avec la commande
  ``` consul agent -server -bootstrap-expect=1 -data-dir= consul-data -ui -bind=ip_adresse ```
- Ajouter une configuration dans les proprietées de **config-service** en ajoutant aussi des annotation ***@EnableConfigServer @EnableDiscoveryClient** dans le main de l'application

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/rep-micro.png)

- Interface de Consul qui contient les services

  ![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/consule.png)

- **Consul Discovery** aide à la gestion, la configuration et la decouverte ds services d'une façon dynamique dans un enviromment distribuées.

#### 2 - Spring Cloud Config
- Utilisation d'un **config-repo** qui contient des varibles des environnements séparées comme dev et prod avec une configuration initiales de chaque microservice cela aide à la gestion des configuration d'une façon simple et dynamiqe

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/config-server-properties.png)

- Utilisation des variables dans un controller web pour le test

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/ctest.png)

- Affichage des variables

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/variable.png)

### 3 - Spring Cloud Gateway
- On a commencé par configurer le service gateway pour eviter la connection directe avec les services.
  ![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/springgateway.png)

### 4 - Customer Service
- Dans ce service on a creer une entité Customer et les données sont stocké dans la BD H2

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/customers.png)
-> En fait on a l'acces au données avec le gatway en utilisant **localhost:9999**

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/customersweb.png)

- Utilisation des projection pour avoir seulement les champs souhaitées.

  ![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/customerRest.png)


### 5 - Inventory Service
- Dans ce service on a creer une entité Product et les données sont stocké dans la BD H2 en configurant aussi les proprietes de microservice, et finalement on a l'acces avec le gateway

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/inventoryProducts.png)

- On a refait la meme chose pour la projection de product

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/projectionInventory.png)


### 6 - Order Service
* La creation du service pour les commandes et la liste des produits associées à chaque commande
* Utilisation de OpenFeign qui assure la communication entre les services en utilisant des REST api(Json)
    - Pour customer service

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/customerRest.png)
- Pour Inventory Service

![image](https://github.com/unesshaba/-all_microservice/blob/main/assets/inventoryRest.png)

**Remarque** : Sans oublier @EnableFeignClient 
