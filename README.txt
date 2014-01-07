Eclipse Kepler
JRE 1.7
MySQL 5.6.12

1- Installation de Tomcat v7.0.47 -
Lien : http://apache.websitebeheerjd.nl/tomcat/tomcat-7/v7.0.47/bin/apache-tomcat-7.0.47-windows-x86.zip
Une fois l'archive téléchargée, dézippez-la à la racine de votre lecteur c:\.

2- Eclipse -
Commencez par désipper le contenu de l'archive dans votre workspace Eclipse.
Importez ensuite le projet :
- File -> Import -> General/Existing Projects into Workspace
- Cliquez sur Next
- Dans le premier champ, sélectionnez votre workspace. Utilisez 'Browse' s'il n'est pas présent dans la liste déroulante.
- Vérifiez que le projet 'Mocomdo' est coché
- Cliquez sur Finish

Le projet est maintenant ouvert dans votre Eclipse.

Ensuite, indiquons où se trouve Tomcat
- Dans la barre de menu, Window -> Preferences
- Dans la colonne de gauche, déroulez 'server' et sélectionnez 'Runtime Environments'


3 - Monitoring du cache -
Lien : http://sourceforge.net/projects/hibernate-jcons/files/beta/hibernate-jconsole-1.0.7.jar/download
Commencez par récupérer le jar donné ci-dessous.

A l'aide de la console, rendez-vous dans le dossier \WebContent\WEB-INF\lib.
Entrez ensuite la commande suivant :
"java -jar hibernate-jconsole-1.0.7.jar"

Une fenêtre s'ouvre. Dans "local process", Sélectionnez "org.apache.catalina.startup.Bootstrap start".
Un message d'erreur peut apparaître, cliquez sur "Insecure".
Ensuite, rendez-vous dans l'onglet "Hibernate Monitor" pour surveiller le cache.