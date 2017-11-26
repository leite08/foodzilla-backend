#! /bin/sh

# The logging configuration appears twice:
# - one is the regular Log4j way of configuring using an external file
# - the second one (-Dlogging.config) is for Spring, otherwise it would load its own log4j configuration file!

echo "Starting Foodzilla Backend..."
cd /home/<username>/foodzilla-backend
java -Dprofile=dev -Dlog4j.configuration=file:log4j.properties -Dlogging.config=file:log4j.properties -jar foodzilla-backend-*.jar > /dev/null &
echo ""
echo "Foodzilla Backend Started."
echo "You can check de logs with ./logs.sh"
echo ""
