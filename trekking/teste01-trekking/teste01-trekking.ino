// Pinos da ponte H
int IN1 = 6, IN2 = 7;  // Direção do motor A
int IN3 = 8, IN4 = 9;  // Direção do motor B
int ENA = 3, ENB = 5;  // Controle PWM dos motores

void setup() {
  // Configurar pinos como saída
  pinMode(IN1, OUTPUT);
  pinMode(IN2, OUTPUT);
  pinMode(IN3, OUTPUT);
  pinMode(IN4, OUTPUT);
  pinMode(ENA, OUTPUT);
  pinMode(ENB, OUTPUT);
 
  // Inicializar os motores parados
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
}

void loop() {
  // Motor A: Girar para frente com 75% da velocidade
  digitalWrite(IN1, HIGH);
  digitalWrite(IN2, LOW);
  analogWrite(ENA, 191); // 75% de 255

  // Motor B: Girar para trás com 50% da velocidade
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, HIGH);
  analogWrite(ENB, 128); // 50% de 255

  delay(2000); // 2 segundos

  // Parar os motores
  digitalWrite(IN1, LOW);
  digitalWrite(IN2, LOW);
  digitalWrite(IN3, LOW);
  digitalWrite(IN4, LOW);
  analogWrite(ENA, 0);
  analogWrite(ENB, 0);

  delay(2000); // 2 segundos
}
