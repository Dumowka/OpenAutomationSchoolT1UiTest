# Запуск тестов локально в Selenoid
1. В терминале текущего проекта поочередно выполнить команды
2. `docker pull nexus.itis.solarlab.ru/aerokube/selenoid:1.10.11`
3. `docker pull selenoid/chrome:122.0`
4. `docker pull selenoid/video-recorder:latest-release`
5. `docker pull selenoid aerokube/selenoid-ui`
6. Вместо {PATH_TO_PROJECT} необходимо вставить полный путь к проекту ui-tests. В формате - "c/Users/user".   Для выставления максимального количества потоков нужно добавить в конец -limit {количество потоков}, по умолчанию 5
   `docker run -d --name selenoid -p 4444:4444 -v "{PATH_TO_PROJECT}/ui-tests/selenoid/browsers.json:/etc/selenoid/browsers.json" -v /var/run/docker.sock:/var/run/docker.sock -v {PATH_TO_PROJECT}/ui-tests/selenoid/video:/opt/selenoid/video/ -e OVERRIDE_VIDEO_OUTPUT_DIR={PATH_TO_PROJECT}/ui-tests/selenoid/video aerokube/selenoid:latest-release`
7. `docker run --rm -d --name selenoid-ui --link selenoid -p 8090:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444`
8. В local.propeties добавить `IS_CI_RUN=true`
9. После поднятия контейнеров, тесты будут запускаться в selenoid и станет доступен selenoid-ui по адресу http://localhost:8090/#/ . Там возможно отслеживать прохождение тестов
10. Видео упавших тестов будут сохраняться в папку selenoid/video/
