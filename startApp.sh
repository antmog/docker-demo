docker rm -f app || sleep 2 && docker pull antmog/docker-demo:9 && sleep 2 && docker run -d -p 8087:8082 --network appandmongo --name app antmog/docker-demo:9