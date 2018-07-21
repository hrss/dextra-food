#!/usr/bin/env bash

docker build . -t hrss/dextra-food
docker push hrss/dextra-food:latest
ssh -i /home/dextra.pem ubuntu@ec2-54-70-206-52.us-west-2.compute.amazonaws.com << EOF
  sudo docker pull hrss/dextra-food
  sudo docker run --rm -d -p 8080:8080 --name app hrss/dextra-food
EOF
