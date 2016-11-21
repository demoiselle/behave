#!/bin/bash


if [ -z $1 ]; 
then
	echo "Informe o número de vezes que o SCRIPT deve ser executado"
	exit;
fi

# Executa o script
for ((i=1;i<=$1;i++)); do
	echo ""
	echo ""
	echo "================== Execution $i =================="
	echo ""
	#mvn test -Dtest=PrimefacesTest
	#mvn test -Dtest=FramesTest
	#mvn test
	./run_test_in_background.sh
done || exit 1
