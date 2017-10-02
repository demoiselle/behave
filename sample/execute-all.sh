#!/bin/bash

HOME_SCRIPT=../../../..
MAVEN=$HOME_SCRIPT/maven-java6/apache-maven-2.2.1/bin/mvn

echo $MAVEN

if [ -z $1 ]; 
then
	echo "Informe o número de vezes que o SCRIPT deve ser executado"
	exit;
fi

for ((i=1;i<=$1;i++)); do
        echo ""
        echo ""
        echo "EXECUÇÃO N $i"
        echo ""
        echo ""

	for dir in */ ; do		
		if [ "$dir" != "treino-desktop/" ]; then
			cd $dir
			# mvn clean test
			$MAVEN test
	
			# Trata o status de retorno do Maven
			STATUS=$?
			echo "==========================================="
			if [ $STATUS -eq 0 ]; then
				echo ">>>>>>>>>>>>>>>>>>>>>>>>>> Successful"
			else
				echo "Failed - Testes abortados"
				exit
			fi
			echo "==========================================="
	
			cd ..
		else
			echo ""
			echo ""
			echo "Pulou o teste de desktop"
			echo ""
			echo ""
		fi
	done
done

echo "==========================================="
echo "PROCCESS FINISHED"
echo "==========================================="

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
