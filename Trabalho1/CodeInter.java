public class CodeInter {

    int calculaCodigo(ArvoreSintatica arv){
        if (arv instanceof Mult) {
            return calculaCodigo(((Mult) arv).arg1) * calculaCodigo(((Mult) arv).arg2);
        } else if (arv instanceof Soma) {
            return calculaCodigo(((Soma) arv).arg1) + calculaCodigo(((Soma) arv).arg2);
        } else if (arv instanceof Sub) {
            return calculaCodigo(((Sub) arv).arg1) - calculaCodigo(((Sub) arv).arg2);
        } else if (arv instanceof Div) {
            return calculaCodigo(((Div) arv).arg1) / calculaCodigo(((Div) arv).arg2);
        } else if (arv instanceof Num) {
            return ((Num) arv).num;
        }
        return 0;
    }
    
}
