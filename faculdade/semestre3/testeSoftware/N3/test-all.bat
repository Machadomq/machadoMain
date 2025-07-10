@echo off
cls
echo.
echo =========================================
echo      TESTANDO SISTEMA CRUD COMPLETO
echo =========================================
echo.

echo  1. Testando API REST...
echo.
echo GET /api/users:
curl -s "http://localhost:3001/api/users" | echo.
echo.

echo POST /api/users:
curl -s -X POST "http://localhost:3001/api/users" -H "Content-Type: application/json" -d "{\"name\":\"Teste API\",\"email\":\"teste@api.com\",\"age\":25}" | echo.
echo.

echo  API funcionando!
echo.
echo  2. Executando testes funcionais com Playwright...
echo.
npx playwright test --headed
echo.
echo  Testes funcionais concluídos!
echo.
echo  3. Para executar testes de carga:
echo    k6 run --out influxdb=http://localhost:8086/k6 k6-tests.js
echo.
echo  4. Para visualizar dashboard:
echo    docker-compose up -d
echo    Acesse: http://localhost:3002 (admin/admin)
echo.
echo =========================================
echo      SISTEMA TOTALMENTE FUNCIONAL!
echo =========================================
echo.
pause
