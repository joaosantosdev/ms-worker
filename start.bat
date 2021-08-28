docker stop hr-config-server
docker rm hr-config-server

docker stop hr-eureka-server
docker rm hr-eureka-server

docker stop hr-api-gateway
docker rm hr-api-gateway

docker run -p 8888:8888 --name hr-config-server --network hr-microservice-net -e GITHUB_USER=joaosantosdev -e GITHUB_PASSWORD=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 -it -d hr-config-server:v1

docker run -p 8761:8761 --name hr-eureka-server --network hr-microservice-net -it -d hr-eureka-server:v1

docker run -p 8765:8765 --name hr-api-gateway --network hr-microservice-net -it -d hr-api-gateway:v1

