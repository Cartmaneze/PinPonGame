package managers;

import javafx.scene.Group;
import models.AbstractBlock;
import models.DoubleBlock;
import models.SimpleBlock;
import models.StoneBlock;

import java.util.ArrayList;

/**
 * Created by Никита on 15.08.2017.
 */
public class BlockManager {
    public static ArrayList<AbstractBlock> blocks = new ArrayList<AbstractBlock>();
    public static ArrayList<AbstractBlock> blocksToDelete = new ArrayList<AbstractBlock>();

    public static Group root;

    public static int countOfStones;

    private static String[] shema1 = new String[]{"559.0_718.0_247.0_77.0_s","999.0_-27.0_44.0_77.0_s","999.0_718.0_44.0_77.0_s","547.0_-27.0_247.0_77.0_s","572.0_225.0_33.0_292.0_s","670.0_96.0_25.0_50.0_b","670.0_146.0_25.0_50.0_b","670.0_196.0_25.0_50.0_b","670.0_346.0_25.0_50.0_b","670.0_296.0_25.0_50.0_b","670.0_246.0_25.0_50.0_b","841.0_146.0_25.0_50.0_b","841.0_96.0_25.0_50.0_b","841.0_46.0_25.0_50.0_b","866.0_146.0_25.0_50.0_b","866.0_96.0_25.0_50.0_b","866.0_46.0_25.0_50.0_b","891.0_146.0_25.0_50.0_b","891.0_96.0_25.0_50.0_b","891.0_46.0_25.0_50.0_b","891.0_196.0_25.0_50.0_b","891.0_246.0_25.0_50.0_b","891.0_296.0_25.0_50.0_b","866.0_196.0_25.0_50.0_b","866.0_246.0_25.0_50.0_b","866.0_296.0_25.0_50.0_b","841.0_196.0_25.0_50.0_b","841.0_246.0_25.0_50.0_b","841.0_296.0_25.0_50.0_b","891.0_346.0_25.0_50.0_b","891.0_396.0_25.0_50.0_b","891.0_446.0_25.0_50.0_b","866.0_346.0_25.0_50.0_b","866.0_396.0_25.0_50.0_b","866.0_446.0_25.0_50.0_b","841.0_346.0_25.0_50.0_b","841.0_396.0_25.0_50.0_b","841.0_446.0_25.0_50.0_b","891.0_496.0_25.0_50.0_b","891.0_546.0_25.0_50.0_b","891.0_596.0_25.0_50.0_b","866.0_496.0_25.0_50.0_b","866.0_546.0_25.0_50.0_b","866.0_596.0_25.0_50.0_b","841.0_496.0_25.0_50.0_b","841.0_546.0_25.0_50.0_b","841.0_596.0_25.0_50.0_b","841.0_646.0_25.0_50.0_b","866.0_646.0_25.0_50.0_b","891.0_646.0_25.0_50.0_b","841.0_696.0_25.0_50.0_b","866.0_696.0_25.0_50.0_b","891.0_696.0_25.0_50.0_b","670.0_546.0_25.0_50.0_b","670.0_596.0_25.0_50.0_b","670.0_496.0_25.0_50.0_b","670.0_446.0_25.0_50.0_b","670.0_396.0_25.0_50.0_b","731.0_273.0_25.0_50.0_b","731.0_223.0_25.0_50.0_b","756.0_273.0_25.0_50.0_b","756.0_223.0_25.0_50.0_b","781.0_273.0_25.0_50.0_b","781.0_223.0_25.0_50.0_b","781.0_175.0_25.0_50.0_b","756.0_175.0_25.0_50.0_b","731.0_175.0_25.0_50.0_b","731.0_517.0_25.0_50.0_b","731.0_469.0_25.0_50.0_b","756.0_517.0_25.0_50.0_b","756.0_469.0_25.0_50.0_b","781.0_517.0_25.0_50.0_b","781.0_469.0_25.0_50.0_b","781.0_421.0_25.0_50.0_b","756.0_421.0_25.0_50.0_b","731.0_421.0_25.0_50.0_b","949.0_100.0_25.0_50.0_b","974.0_100.0_25.0_50.0_b","999.0_100.0_25.0_50.0_b","949.0_642.0_25.0_50.0_b","974.0_642.0_25.0_50.0_b","999.0_642.0_25.0_50.0_b","949.0_346.0_25.0_50.0_b","974.0_346.0_25.0_50.0_b","999.0_346.0_25.0_50.0_b"};
    private static String[] shema2 = new String[]{"878.0_132.0_25.0_50.0_b","878.0_182.0_25.0_50.0_b","878.0_282.0_25.0_50.0_b","878.0_232.0_25.0_50.0_b","853.0_132.0_25.0_200.0_s","903.0_232.0_25.0_50.0_b","903.0_282.0_25.0_50.0_b","903.0_182.0_25.0_50.0_b","903.0_132.0_25.0_50.0_b","853.0_534.0_25.0_50.0_b","853.0_584.0_25.0_50.0_b","853.0_684.0_25.0_50.0_b","853.0_634.0_25.0_50.0_b","803.0_534.0_25.0_200.0_s","828.0_634.0_25.0_50.0_b","828.0_684.0_25.0_50.0_b","828.0_584.0_25.0_50.0_b","828.0_534.0_25.0_50.0_b","716.0_26.0_25.0_50.0_b","716.0_76.0_25.0_50.0_b","716.0_176.0_25.0_50.0_b","716.0_126.0_25.0_50.0_b","666.0_26.0_25.0_200.0_s","691.0_126.0_25.0_50.0_b","691.0_176.0_25.0_50.0_b","691.0_76.0_25.0_50.0_b","691.0_26.0_25.0_50.0_b","666.0_315.0_25.0_50.0_b","666.0_365.0_25.0_50.0_b","666.0_465.0_25.0_50.0_b","666.0_415.0_25.0_50.0_b","641.0_315.0_25.0_200.0_s","691.0_415.0_25.0_50.0_b","691.0_465.0_25.0_50.0_b","691.0_365.0_25.0_50.0_b","691.0_315.0_25.0_50.0_b","766.0_157.0_25.0_50.0_b","766.0_207.0_25.0_50.0_b","791.0_207.0_25.0_50.0_b","791.0_157.0_25.0_50.0_b","779.0_390.0_25.0_50.0_b","779.0_440.0_25.0_50.0_b","804.0_440.0_25.0_50.0_b","804.0_390.0_25.0_50.0_b","828.0_390.0_25.0_50.0_b","828.0_440.0_25.0_50.0_b","853.0_440.0_25.0_50.0_b","853.0_390.0_25.0_50.0_b","878.0_390.0_25.0_50.0_b","878.0_440.0_25.0_50.0_b","903.0_440.0_25.0_50.0_b","903.0_390.0_25.0_50.0_b","616.0_577.0_25.0_50.0_b","591.0_577.0_25.0_50.0_b","566.0_577.0_25.0_50.0_b","541.0_627.0_25.0_50.0_b","541.0_577.0_25.0_50.0_b","691.0_627.0_25.0_50.0_b","691.0_677.0_25.0_50.0_b","666.0_677.0_25.0_50.0_b","641.0_677.0_25.0_50.0_b","616.0_677.0_25.0_50.0_b","592.0_677.0_25.0_50.0_b","567.0_677.0_25.0_50.0_b","565.0_627.0_126.0_50.0_s","641.0_76.0_25.0_50.0_b","641.0_26.0_25.0_50.0_b","641.0_176.0_25.0_50.0_b","641.0_126.0_25.0_50.0_b","616.0_365.0_25.0_50.0_b","616.0_315.0_25.0_50.0_b","616.0_465.0_25.0_50.0_b","616.0_415.0_25.0_50.0_b","991.0_8.0_25.0_50.0_b","991.0_58.0_25.0_50.0_b","966.0_58.0_25.0_50.0_b","966.0_8.0_25.0_50.0_b","991.0_107.0_25.0_50.0_b","991.0_157.0_25.0_50.0_b","966.0_157.0_25.0_50.0_b","966.0_107.0_25.0_50.0_b","991.0_207.0_25.0_50.0_b","991.0_257.0_25.0_50.0_b","966.0_257.0_25.0_50.0_b","966.0_207.0_25.0_50.0_b","966.0_639.0_25.0_50.0_b","966.0_689.0_25.0_50.0_b","991.0_689.0_25.0_50.0_b","991.0_639.0_25.0_50.0_b","966.0_539.0_25.0_50.0_b","966.0_589.0_25.0_50.0_b","991.0_589.0_25.0_50.0_b","991.0_539.0_25.0_50.0_b","966.0_440.0_25.0_50.0_b","966.0_490.0_25.0_50.0_b","991.0_490.0_25.0_50.0_b","991.0_440.0_25.0_50.0_b","512.0_-42.0_25.0_200.0_s","474.0_589.0_25.0_200.0_s","516.0_232.0_25.0_50.0_b","516.0_282.0_25.0_50.0_b","516.0_332.0_25.0_50.0_b","491.0_332.0_25.0_50.0_b","491.0_282.0_25.0_50.0_b","491.0_232.0_25.0_50.0_b","491.0_382.0_25.0_50.0_b","491.0_432.0_25.0_50.0_b","491.0_482.0_25.0_50.0_b","516.0_482.0_25.0_50.0_b","516.0_432.0_25.0_50.0_b","516.0_382.0_25.0_50.0_b"};
    private static String[] shema3 = new String[]{"560.0_284.0_25.0_50.0_b","560.0_334.0_25.0_50.0_b","560.0_384.0_25.0_50.0_b","560.0_434.0_25.0_50.0_b","661.0_434.0_25.0_50.0_b","661.0_384.0_25.0_50.0_b","661.0_334.0_25.0_50.0_b","661.0_284.0_25.0_50.0_b","585.0_283.0_76.0_201.0_s","560.0_117.0_25.0_50.0_b","560.0_67.0_25.0_50.0_b","661.0_67.0_25.0_50.0_b","661.0_117.0_25.0_50.0_b","661.0_649.0_25.0_50.0_b","661.0_599.0_25.0_50.0_b","560.0_599.0_25.0_50.0_b","560.0_649.0_25.0_50.0_b","585.0_67.0_76.0_100.0_s","585.0_599.0_76.0_100.0_s","751.0_104.0_174.0_26.0_s","751.0_636.0_174.0_26.0_s","836.0_234.0_25.0_300.0_s","861.0_234.0_25.0_50.0_b","861.0_284.0_25.0_50.0_b","861.0_334.0_25.0_50.0_b","861.0_384.0_25.0_50.0_b","861.0_434.0_25.0_50.0_b","861.0_484.0_25.0_50.0_b","811.0_234.0_25.0_50.0_b","811.0_284.0_25.0_50.0_b","811.0_334.0_25.0_50.0_b","811.0_384.0_25.0_50.0_b","811.0_434.0_25.0_50.0_b","811.0_484.0_25.0_50.0_b","751.0_130.0_25.0_50.0_b","776.0_130.0_25.0_50.0_b","801.0_130.0_25.0_50.0_b","876.0_130.0_25.0_50.0_b","851.0_130.0_25.0_50.0_b","826.0_130.0_25.0_50.0_b","826.0_54.0_25.0_50.0_b","851.0_54.0_25.0_50.0_b","876.0_54.0_25.0_50.0_b","801.0_54.0_25.0_50.0_b","776.0_54.0_25.0_50.0_b","751.0_54.0_25.0_50.0_b","901.0_130.0_25.0_50.0_b","901.0_54.0_25.0_50.0_b","901.0_586.0_25.0_50.0_b","901.0_662.0_25.0_50.0_b","751.0_586.0_25.0_50.0_b","776.0_586.0_25.0_50.0_b","801.0_586.0_25.0_50.0_b","876.0_586.0_25.0_50.0_b","851.0_586.0_25.0_50.0_b","826.0_586.0_25.0_50.0_b","826.0_662.0_25.0_50.0_b","851.0_662.0_25.0_50.0_b","876.0_662.0_25.0_50.0_b","801.0_662.0_25.0_50.0_b","776.0_662.0_25.0_50.0_b","751.0_662.0_25.0_50.0_b","985.0_484.0_25.0_50.0_b","985.0_434.0_25.0_50.0_b","985.0_384.0_25.0_50.0_b","985.0_334.0_25.0_50.0_b","985.0_284.0_25.0_50.0_b","985.0_234.0_25.0_50.0_b","960.0_384.0_25.0_50.0_b","960.0_334.0_25.0_50.0_b","960.0_284.0_25.0_50.0_b","960.0_234.0_25.0_50.0_b","960.0_184.0_25.0_50.0_b","960.0_134.0_25.0_50.0_b","960.0_584.0_25.0_50.0_b","960.0_534.0_25.0_50.0_b","960.0_484.0_25.0_50.0_b","960.0_434.0_25.0_50.0_b","686.0_384.0_25.0_50.0_b","686.0_334.0_25.0_50.0_b","711.0_384.0_25.0_50.0_b","711.0_334.0_25.0_50.0_b","736.0_384.0_25.0_50.0_b","736.0_334.0_25.0_50.0_b","761.0_384.0_25.0_50.0_b","761.0_334.0_25.0_50.0_b","786.0_384.0_25.0_50.0_b","786.0_334.0_25.0_50.0_b","560.0_17.0_25.0_50.0_b","585.0_17.0_25.0_50.0_b","610.0_17.0_25.0_50.0_b","635.0_17.0_25.0_50.0_b","660.0_17.0_25.0_50.0_b","660.0_699.0_25.0_50.0_b","635.0_699.0_25.0_50.0_b","610.0_699.0_25.0_50.0_b","585.0_699.0_25.0_50.0_b","560.0_699.0_25.0_50.0_b","573.0_168.0_50.0_25.0_b","623.0_168.0_50.0_25.0_b","623.0_574.0_50.0_25.0_b","573.0_574.0_50.0_25.0_b","623.0_259.0_50.0_25.0_b","573.0_259.0_50.0_25.0_b","623.0_484.0_50.0_25.0_b","573.0_484.0_50.0_25.0_b"};
    private static String[] shema4 = new String[]{"550.0_209.0_25.0_50.0_b","550.0_259.0_25.0_50.0_b","550.0_309.0_25.0_50.0_b","550.0_459.0_25.0_50.0_b","550.0_409.0_25.0_50.0_b","550.0_359.0_25.0_50.0_b","868.0_409.0_50.0_50.0_d","743.0_604.0_25.0_50.0_b","743.0_654.0_25.0_50.0_b","743.0_704.0_25.0_50.0_b","743.0_554.0_25.0_50.0_b","743.0_504.0_25.0_50.0_b","743.0_454.0_25.0_50.0_b","881.0_14.0_25.0_50.0_b","881.0_64.0_25.0_50.0_b","881.0_114.0_25.0_50.0_b","881.0_264.0_25.0_50.0_b","881.0_214.0_25.0_50.0_b","881.0_164.0_25.0_50.0_b","970.0_420.0_25.0_50.0_b","970.0_470.0_25.0_50.0_b","970.0_520.0_25.0_50.0_b","970.0_370.0_25.0_50.0_b","970.0_320.0_25.0_50.0_b","970.0_270.0_25.0_50.0_b","718.0_454.0_25.0_50.0_b","718.0_504.0_25.0_50.0_b","718.0_554.0_25.0_50.0_b","718.0_704.0_25.0_50.0_b","718.0_654.0_25.0_50.0_b","718.0_604.0_25.0_50.0_b","525.0_309.0_25.0_50.0_b","525.0_359.0_25.0_50.0_b","525.0_409.0_25.0_50.0_b","525.0_259.0_25.0_50.0_b","525.0_209.0_25.0_50.0_b","525.0_159.0_25.0_50.0_b","575.0_259.0_25.0_50.0_b","575.0_309.0_25.0_50.0_b","575.0_359.0_25.0_50.0_b","575.0_509.0_25.0_50.0_b","575.0_459.0_25.0_50.0_b","575.0_409.0_25.0_50.0_b","856.0_164.0_25.0_50.0_b","856.0_214.0_25.0_50.0_b","856.0_264.0_25.0_50.0_b","856.0_114.0_25.0_50.0_b","856.0_64.0_25.0_50.0_b","856.0_14.0_25.0_50.0_b","844.0_409.0_25.0_50.0_b","918.0_409.0_25.0_50.0_b","843.0_458.0_50.0_25.0_b","893.0_458.0_50.0_25.0_b","844.0_383.0_50.0_25.0_b","893.0_383.0_50.0_25.0_b","881.0_593.0_50.0_25.0_b","832.0_593.0_50.0_25.0_b","881.0_668.0_50.0_25.0_b","831.0_668.0_50.0_25.0_b","906.0_619.0_25.0_50.0_b","832.0_619.0_25.0_50.0_b","856.0_619.0_50.0_50.0_d","718.0_270.0_50.0_25.0_b","669.0_270.0_50.0_25.0_b","718.0_345.0_50.0_25.0_b","668.0_345.0_50.0_25.0_b","743.0_296.0_25.0_50.0_b","669.0_296.0_25.0_50.0_b","693.0_296.0_50.0_50.0_d","731.0_59.0_50.0_25.0_b","682.0_59.0_50.0_25.0_b","731.0_134.0_50.0_25.0_b","681.0_134.0_50.0_25.0_b","756.0_85.0_25.0_50.0_b","682.0_85.0_25.0_50.0_b","706.0_85.0_50.0_50.0_d","619.0_209.0_210.0_25.0_s","819.0_522.0_124.0_25.0_s","455.0_668.0_232.0_25.0_s","380.0_-56.0_232.0_83.0_s"};
    private static String[] shema5 = new String[]{"550.0_209.0_25.0_50.0_b","550.0_259.0_25.0_50.0_b","550.0_309.0_25.0_50.0_b","550.0_409.0_25.0_50.0_b","550.0_359.0_25.0_50.0_b","743.0_604.0_25.0_50.0_b","743.0_654.0_25.0_50.0_b","743.0_554.0_25.0_50.0_b","743.0_504.0_25.0_50.0_b","719.0_654.0_25.0_50.0_d","719.0_604.0_25.0_50.0_d","719.0_555.0_25.0_50.0_d","719.0_505.0_25.0_50.0_d","768.0_505.0_25.0_50.0_d","768.0_555.0_25.0_50.0_d","768.0_604.0_25.0_50.0_d","768.0_654.0_25.0_50.0_d","694.0_184.0_25.0_50.0_d","694.0_134.0_25.0_50.0_d","694.0_85.0_25.0_50.0_d","694.0_35.0_25.0_50.0_d","645.0_35.0_25.0_50.0_d","645.0_85.0_25.0_50.0_d","645.0_134.0_25.0_50.0_d","645.0_184.0_25.0_50.0_d","669.0_34.0_25.0_50.0_b","669.0_84.0_25.0_50.0_b","669.0_184.0_25.0_50.0_b","669.0_134.0_25.0_50.0_b","908.0_384.0_25.0_50.0_d","908.0_334.0_25.0_50.0_d","908.0_285.0_25.0_50.0_d","908.0_235.0_25.0_50.0_d","859.0_235.0_25.0_50.0_d","859.0_285.0_25.0_50.0_d","859.0_334.0_25.0_50.0_d","859.0_384.0_25.0_50.0_d","883.0_234.0_25.0_50.0_b","883.0_284.0_25.0_50.0_b","883.0_384.0_25.0_50.0_b","883.0_334.0_25.0_50.0_b","896.0_629.0_25.0_50.0_b","896.0_579.0_25.0_50.0_b","896.0_529.0_25.0_50.0_b","921.0_529.0_25.0_50.0_b","921.0_579.0_25.0_50.0_b","921.0_629.0_25.0_50.0_b","756.0_392.0_25.0_50.0_b","756.0_342.0_25.0_50.0_b","756.0_292.0_25.0_50.0_b","731.0_292.0_25.0_50.0_b","731.0_342.0_25.0_50.0_b","731.0_392.0_25.0_50.0_b","847.0_148.0_25.0_50.0_b","847.0_98.0_25.0_50.0_b","847.0_48.0_25.0_50.0_b","822.0_48.0_25.0_50.0_b","822.0_98.0_25.0_50.0_b","822.0_148.0_25.0_50.0_b","563.0_608.0_25.0_196.0_s","500.0_-49.0_25.0_196.0_s","575.0_309.0_85.0_101.0_d","658.0_360.0_25.0_50.0_b","658.0_310.0_25.0_50.0_b","575.0_410.0_50.0_25.0_b","625.0_410.0_50.0_25.0_b","575.0_285.0_50.0_25.0_b","625.0_285.0_50.0_25.0_b","575.0_435.0_50.0_25.0_b","625.0_435.0_50.0_25.0_b","575.0_259.0_50.0_25.0_b","625.0_259.0_50.0_25.0_b","550.0_159.0_25.0_50.0_b","550.0_109.0_25.0_50.0_b","576.0_109.0_25.0_50.0_b","576.0_159.0_25.0_50.0_b","576.0_209.0_25.0_50.0_b","651.0_560.0_25.0_50.0_b","651.0_510.0_25.0_50.0_b","651.0_460.0_25.0_50.0_b","625.0_460.0_25.0_50.0_b","625.0_510.0_25.0_50.0_b","625.0_560.0_25.0_50.0_b","967.0_729.0_50.0_25.0_b","917.0_729.0_50.0_25.0_b","818.0_729.0_50.0_25.0_b","868.0_729.0_50.0_25.0_b","768.0_729.0_50.0_25.0_b","718.0_729.0_50.0_25.0_b","619.0_729.0_50.0_25.0_b","669.0_729.0_50.0_25.0_b"};
    private static String[] shema6 = new String[]{"576.0_134.0_251.0_25.0_s","778.0_534.0_25.0_50.0_d","741.0_359.0_25.0_50.0_b","576.0_608.0_251.0_25.0_s","778.0_484.0_25.0_50.0_d","778.0_384.0_25.0_50.0_d","778.0_434.0_25.0_50.0_d","778.0_234.0_25.0_50.0_d","778.0_184.0_25.0_50.0_d","778.0_284.0_25.0_50.0_d","778.0_334.0_25.0_50.0_d","777.0_109.0_50.0_25.0_d","727.0_109.0_50.0_25.0_d","677.0_109.0_50.0_25.0_d","627.0_109.0_50.0_25.0_d","577.0_109.0_50.0_25.0_d","577.0_633.0_50.0_25.0_d","627.0_633.0_50.0_25.0_d","677.0_633.0_50.0_25.0_d","727.0_633.0_50.0_25.0_d","777.0_633.0_50.0_25.0_d","716.0_334.0_25.0_50.0_b","716.0_384.0_25.0_50.0_b","691.0_334.0_25.0_50.0_b","691.0_284.0_25.0_50.0_b","691.0_384.0_25.0_50.0_b","691.0_434.0_25.0_50.0_b","666.0_434.0_25.0_50.0_b","666.0_384.0_25.0_50.0_b","666.0_284.0_25.0_50.0_b","666.0_334.0_25.0_50.0_b","666.0_484.0_25.0_50.0_b","666.0_234.0_25.0_50.0_b","641.0_234.0_25.0_50.0_b","641.0_484.0_25.0_50.0_b","641.0_334.0_25.0_50.0_b","641.0_284.0_25.0_50.0_b","641.0_384.0_25.0_50.0_b","641.0_434.0_25.0_50.0_b","641.0_534.0_25.0_50.0_b","641.0_184.0_25.0_50.0_b","616.0_234.0_25.0_50.0_b","616.0_484.0_25.0_50.0_b","616.0_334.0_25.0_50.0_b","616.0_284.0_25.0_50.0_b","616.0_384.0_25.0_50.0_b","616.0_434.0_25.0_50.0_b","591.0_434.0_25.0_50.0_b","591.0_384.0_25.0_50.0_b","591.0_284.0_25.0_50.0_b","591.0_334.0_25.0_50.0_b","566.0_384.0_25.0_50.0_b","566.0_334.0_25.0_50.0_b","541.0_359.0_25.0_50.0_b","859.0_109.0_25.0_50.0_b","859.0_159.0_25.0_50.0_b","884.0_209.0_25.0_50.0_b","884.0_159.0_25.0_50.0_b","884.0_59.0_25.0_50.0_b","884.0_109.0_25.0_50.0_b","909.0_209.0_25.0_50.0_b","909.0_159.0_25.0_50.0_b","909.0_59.0_25.0_50.0_b","909.0_109.0_25.0_50.0_b","909.0_259.0_25.0_50.0_b","909.0_9.0_25.0_50.0_b","934.0_109.0_25.0_50.0_b","934.0_59.0_25.0_50.0_b","934.0_159.0_25.0_50.0_b","934.0_209.0_25.0_50.0_b","959.0_159.0_25.0_50.0_b","959.0_109.0_25.0_50.0_b","859.0_558.0_25.0_50.0_b","859.0_608.0_25.0_50.0_b","884.0_658.0_25.0_50.0_b","884.0_608.0_25.0_50.0_b","884.0_508.0_25.0_50.0_b","884.0_558.0_25.0_50.0_b","909.0_658.0_25.0_50.0_b","909.0_608.0_25.0_50.0_b","909.0_508.0_25.0_50.0_b","909.0_558.0_25.0_50.0_b","909.0_708.0_25.0_50.0_b","909.0_458.0_25.0_50.0_b","934.0_558.0_25.0_50.0_b","934.0_508.0_25.0_50.0_b","934.0_608.0_25.0_50.0_b","934.0_658.0_25.0_50.0_b","959.0_608.0_25.0_50.0_b","959.0_558.0_25.0_50.0_b","577.0_733.0_50.0_25.0_b","627.0_733.0_50.0_25.0_b","777.0_733.0_50.0_25.0_b","827.0_733.0_50.0_25.0_b","727.0_733.0_50.0_25.0_b","677.0_733.0_50.0_25.0_b","577.0_9.0_50.0_25.0_b","627.0_9.0_50.0_25.0_b","777.0_9.0_50.0_25.0_b","827.0_9.0_50.0_25.0_b","727.0_9.0_50.0_25.0_b","677.0_9.0_50.0_25.0_b","802.0_184.0_25.0_50.0_b","802.0_534.0_25.0_50.0_b","802.0_434.0_25.0_50.0_b","802.0_384.0_25.0_50.0_b","802.0_284.0_25.0_50.0_b","802.0_334.0_25.0_50.0_b","802.0_484.0_25.0_50.0_b","802.0_234.0_25.0_50.0_b","677.0_708.0_50.0_25.0_b","727.0_708.0_50.0_25.0_b","777.0_708.0_50.0_25.0_b","627.0_708.0_50.0_25.0_b","577.0_708.0_50.0_25.0_b","677.0_34.0_50.0_25.0_b","727.0_34.0_50.0_25.0_b","777.0_34.0_50.0_25.0_b","627.0_34.0_50.0_25.0_b","577.0_34.0_50.0_25.0_b","577.0_683.0_50.0_25.0_b","627.0_683.0_50.0_25.0_b","727.0_683.0_50.0_25.0_b","677.0_683.0_50.0_25.0_b","577.0_59.0_50.0_25.0_b","627.0_59.0_50.0_25.0_b","727.0_59.0_50.0_25.0_b","677.0_59.0_50.0_25.0_b","678.0_658.0_50.0_25.0_b","628.0_658.0_50.0_25.0_b","578.0_658.0_50.0_25.0_b","677.0_84.0_50.0_25.0_b","627.0_84.0_50.0_25.0_b","577.0_84.0_50.0_25.0_b","909.0_309.0_25.0_50.0_b","909.0_409.0_25.0_50.0_b","909.0_359.0_25.0_50.0_b","934.0_359.0_25.0_50.0_b","884.0_359.0_25.0_50.0_b","934.0_309.0_25.0_50.0_b","884.0_309.0_25.0_50.0_b","934.0_409.0_25.0_50.0_b","884.0_409.0_25.0_50.0_b","959.0_359.0_25.0_50.0_b","859.0_359.0_25.0_50.0_b"};


    private static ArrayList<String[]> allShemas = new ArrayList<String[]>();

    public synchronized static ArrayList<AbstractBlock> initBlocks() {
        countOfStones = 0;
        blocks.clear();
        setAllShemas();

        int shemaNumber = 0 + (int) (Math.random() * allShemas.size());

        for (String coordinates : allShemas.get(shemaNumber)) {
            double xCoord = 0;
            double yCoord = 0;
            double width = 0;
            double height = 0;
            String color = "";

            String[] coordSplitter = coordinates.split("_");
            xCoord = Double.parseDouble(coordSplitter[0]);
            yCoord = Double.parseDouble(coordSplitter[1]);
            width = Double.parseDouble(coordSplitter[2]);
            height = Double.parseDouble(coordSplitter[3]);
            color = coordSplitter[4];

            AbstractBlock block;

            if (color.equals("b")) {
                block = new SimpleBlock((int) xCoord, (int) yCoord, (int) width, (int) height);
            } else if (color.equals("s")) {
                block = new StoneBlock((int) xCoord, (int) yCoord, (int) width, (int) height);
                countOfStones++;
            } else if (color.equals("d")) {
                block = new DoubleBlock((int) xCoord, (int) yCoord, (int) width, (int) height);
            } else {
                block = new SimpleBlock(0, 0, 0, 0);
            }

            blocks.add(block);
        }

        return blocks;
    }

    private static void setAllShemas() {
        allShemas.add(shema1);
        allShemas.add(shema2);
        allShemas.add(shema3);
        allShemas.add(shema4);
        allShemas.add(shema5);
        allShemas.add(shema6);
    }

}
