install:
	go build && go install

docker:
	docker build -t workmachine/workmachine .
	docker push workmachine/workmachine
