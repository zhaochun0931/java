# Server Certificate

keytool -genkey -alias serverkey -keyalg RSA -keysize 2048 -sigalg SHA256withRSA -storetype pkcs12 -keystore serverkeystore.p12 -storepass password -ext san=ip:127.0.0.1,dns:localhost

keytool -exportcert -keystore serverkeystore.p12 -alias serverkey -storepass password -rfc -file server-certificate.pem

keytool -import -trustcacerts -file server-certificate.pem -keypass password -storepass password -keystore clienttruststore.jks





# Client Certificate

keytool -genkey -alias clientkey -keyalg RSA -keysize 2048 -sigalg SHA256withRSA -keystore clientkeystore.p12 -storepass password -ext san=ip:127.0.0.1,dns:localhost

keytool -exportcert -keystore clientkeystore.p12 -alias clientkey -storepass password -rfc -file client-certificate.pem

keytool -import -trustcacerts -file client-certificate.pem -keypass password -storepass password -keystore servertruststore.jks





java -Djavax.net.ssl.keyStore=/tmp/serverkeystore.p12 \
-Djavax.net.ssl.keyStorePassword=password \
-Djavax.net.ssl.trustStore=/tmp/servertruststore.jks \
-Djavax.net.ssl.trustStorePassword=password \
SSLSocketEchoServer






java -Djavax.net.ssl.keyStore=/tmp/clientkeystore.p12 \
-Djavax.net.ssl.keyStorePassword=password \
-Djavax.net.ssl.trustStore=/tmp/clienttruststore.jks \
-Djavax.net.ssl.trustStorePassword=password \
SSLSocketClient
