# Server Certificate
keytool -genkey -alias server -keyalg RSA -keysize 2048 -sigalg SHA256withRSA -storetype pkcs12 -keystore server.p12 -storepass password -ext san=ip:127.0.0.1,dns:localhost
keytool -exportcert -keystore server.p12 -alias server -storepass password -rfc -file server.crt
keytool -import -alias server -trustcacerts -file server.crt -keypass password -storepass password -keystore client.jks -noprompt





# Client Certificate
keytool -genkey -alias client -keyalg RSA -keysize 2048 -sigalg SHA256withRSA -storetype pkcs12 -keystore client.p12 -storepass password -ext san=ip:127.0.0.1,dns:localhost
keytool -exportcert -keystore client.p12 -alias client -storepass password -rfc -file client.crt
keytool -import -alias client -trustcacerts -file client.crt -keypass password -storepass password -keystore client.jks -noprompt






# run java tls server
java -Djavax.net.ssl.keyStore=/tmp/server.p12 \
-Djavax.net.ssl.keyStorePassword=password \
-Djavax.net.ssl.trustStore=/tmp/client.jks \
-Djavax.net.ssl.trustStorePassword=password \
tlsserver





# run java tls client
java -Djavax.net.ssl.keyStore=/tmp/client.p12 \
-Djavax.net.ssl.keyStorePassword=password \
-Djavax.net.ssl.trustStore=/tmp/client.jks \
-Djavax.net.ssl.trustStorePassword=password \
tlsclient
