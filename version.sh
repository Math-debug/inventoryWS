sudo docker build .
tag='mxavier27/inventario:0.0.1-SNAPSHOT' && sudo docker build -t $tag . && sudo docker push $tag
