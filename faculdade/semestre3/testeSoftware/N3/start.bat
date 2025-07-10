@echo off
echo 🚀 Iniciando Sistema CRUD Completo
echo.

echo 📦 Instalando dependências...
npm install

echo.
echo 🔧 Instalando Playwright...
npx playwright install

echo.
echo 📊 Iniciando Grafana e InfluxDB...
docker-compose up -d

echo.
echo ⏳ Aguardando serviços iniciarem...
timeout /t 10 /nobreak

echo.
echo 🌐 Iniciando servidor da aplicação...
echo.
echo ✅ Sistema pronto!
echo.
echo 📍 Acesse:
echo   • Aplicação: http://localhost:3001
echo   • Grafana: http://localhost:3002 (admin/admin)
echo.
echo  Para executar testes:
echo   • Testes funcionais: npm test
echo   • Testes de carga: k6 run --out influxdb=http://localhost:8086/k6 k6-tests.js
echo.

npm start
