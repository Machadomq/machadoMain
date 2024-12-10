// Pinos da ponte H
int IN1 = 6, IN2 = 7;  // Direção do motor A (frente)
int IN3 = 8, IN4 = 9;  // Direção do motor B (atrás)
int ENA = 3, ENB = 5;  // Controle PWM dos motores

void setup() {
  // Configuração dos pinos como saída
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);
  pinMode(ENA, OUTPUT);
  pinMode(ENB, OUTPUT);

  // Parar os motores ao iniciar
  pararMotores();
}

void loop() {
  // Andar para frente
  andarParaFrente();
  delay(3000);  // Vai para frente por 3 segundos

  // Andar para trás
  andarParaTras();
  delay(3000);  // Vai para trás por 3 segundos

  // Parar os motores
  pararMotores();
  delay(2000);  // Espera 2 segundos antes de repetir
}

//-----------------------------------------------------------------------------

// andar para frente
void andarParaFrente() {
  // Direção frente para ambos os motores
  digitalWrite(IN1, HIGH);  // Motor A (frente) para frente
  digitalWrite(IN2, LOW);
  
  digitalWrite(IN3, HIGH);  // Motor B (trás) para frente
  digitalWrite(IN4, LOW);

  // Ajuste de velocidade
  analogWrite(ENA, 255);  // Motor A com velocidade máxima
  analogWrite(ENB, 255);  // Motor B com velocidade máxima
}

// andar para trás
void andarParaTras() {
  // Direção para trás para ambos os motores
  digitalWrite(IN1, LOW);   // Motor A (frente) para trás
  digitalWrite(IN2, HIGH);
  
  digitalWrite(IN3, LOW);   // Motor B (trás) para trás
  digitalWrite(IN4, HIGH);

  // Ajuste de velocidade
  analogWrite(ENA, 255);  // Motor A com velocidade máxima
  analogWrite(ENB, 255);  // Motor B com velocidade máxima
}

// parar os motores
void pararMotores() {
  // Desliga os dois motores
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
  
  // Para os motores com PWM
  analogWrite(ENA, 0);
  analogWrite(ENB, 0);
}
