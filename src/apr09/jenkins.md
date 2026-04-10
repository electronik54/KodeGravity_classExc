# INSTALL JENKINS ON EC2 INSTANCE
##### REF: https://www.jenkins.io/doc/tutorials/tutorial-for-installing-jenkins-on-AWS/


### Connect to EC2 instance
  - icacls .\jenkinsKey.pem /inheritance:r
  - ssh -i "jenkinsKey.pem" ec2-user@ec2-98-92-104-1.compute-1.amazonaws.com

- follow the steps to install jenkins on ref link
- once you reach `Configuring Jenkins` where you Connect to http://<your_server_public_DNS>:8080 from your browser, make sure you have edited your server instance `inbound rules` in instance>Security>Security groups>inbound rules>Edit inbound rules. 
  - delete all the rules and add just 1 rule. Type=All traffic, Source=Custom, 0.0.0.0 and save
  - try connecting to the http://<your_server_public_DNS>:8080 and it should connect
- follow the next steps on the ref link after you get your password
- install suggested plugins > wait for it to finish
- Ex: in `/_ign_`