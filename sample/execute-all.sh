#!/bin/bash


if [ -z $1 ]; 
then
	echo "Informe o número de vezes que o SCRIPT deve ser executado"
	exit;
fi

for ((i=1;i<=$1;i++)); do
	for d in */ ; do
		cd $d
		mvn clean test

		# Trata o status de retorno do Maven
		STATUS=$?
		echo "==========================================="
		if [ $STATUS -eq 0 ]; then
			echo "Successful"
		else
			echo "Failed - Testes abortados"
			exit
		fi
		echo "==========================================="

		cd ..
	done
done

exit()

# Executa o script
#for ((i=1;i<=$1;i++)); do
#	echo ""
#	echo ""
#	echo "================== Execution $i =================="
#	echo ""
#	#mvn test -Dtest=PrimefacesTest
#	#mvn test -Dtest=FramesTest
#	mvn test
#	#./run_test_in_background.sh
#done || exit 1
