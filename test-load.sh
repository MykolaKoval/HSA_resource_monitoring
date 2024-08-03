#!/bin/bash

ab -n 100000 -c 100 -p task-payload.json -T application/json http://127.0.0.1/hsa-app/api/tasks