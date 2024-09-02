public class ex1 {

    public static void main(String[] args) {
        
        int gastosJaneiro = 15000;
        int gastosFevereiro = 23000;
        int gastosMarco = 17000;

        int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;

        System.out.println("gasto trimestral:" + gastosTrimestre);

        int mediaMensal = gastosTrimestre/3;
        System.out.println("media de gasto por mes:"+mediaMensal);
        
    }
}
