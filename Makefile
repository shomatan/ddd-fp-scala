.DEFAULT_GOAL := help

DOCKER_IMAGE_NAME = graal-builder
SCALA_VERSION     = 2.12
JAR_NAME          = ddd-fp-scala.jar

build:  ## Build to jar file
	@sbt clean test assembly

native: ## Build to native image
	@if ! `docker images | grep -q $(DOCKER_IMAGE_NAME)`; then \
		docker build -t $(DOCKER_IMAGE_NAME) docker/; \
	fi
	make build
	docker run --rm -it -v ${PWD}/target/scala-$(SCALA_VERSION):/work $(DOCKER_IMAGE_NAME) -jar $(JAR_NAME)

.PHONY: help
help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'