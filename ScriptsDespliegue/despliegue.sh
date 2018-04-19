#!/bin/bash

clear
ips=( localhost $@ )
if ! [ -e /home/$USER/.ssh/id_rsa ]; then
	ssh-keygen
	for (( i=1; i<${#ips[@]}; i++ )) do
		ssh-copy-id -i ~/.ssh/id_rsa.pub $USER@${ips[$i]}
	done
fi

#tar xzf PracticaObligatoriaISIS.tar.gz 
#./tomcat-ISIS/bin/startup.sh
for (( i=1; i<${#ips[@]}; i++ )) do
	./remoto.sh ${ips[$i]}
done
