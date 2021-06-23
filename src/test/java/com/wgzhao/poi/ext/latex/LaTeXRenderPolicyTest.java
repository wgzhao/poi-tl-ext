package com.wgzhao.poi.ext.latex;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

class LaTeXRenderPolicyTest {

    @Test
    void doRender() throws IOException {
        LaTeXRenderPolicy laTeXRenderPolicy = new LaTeXRenderPolicy();
        Configure configure = Configure.builder()
                .bind("math1", laTeXRenderPolicy)
                .bind("math2", laTeXRenderPolicy)
                .bind("math3", laTeXRenderPolicy)
                .bind("math4", laTeXRenderPolicy)
                .build();
        Map<String, Object> data = new HashMap<>(4);
        String math1 = "注：\n" +
                "业绩报酬计提基准日为集合计划退出日、分红权益登记日或集合计划终止日。若业绩报酬计提基准日为集合计划退出日或分红权益登记日，则业绩报酬计提日为基准日当日；若业绩报酬计提基准日为集合计划终止日，则业绩报酬计提日以管理人清算方案为准。\n" +
                "本集合计划仅在本集合计划单位净值符合本款第2点所述条件时计提业绩报酬。\n" +
                "业绩报酬计提方法：\n" +
                "在业绩报酬计提日，集合计划委托人所持每笔份额在运作周期内的持有期间年化收益率大于该运作周期业绩报酬计提基准时，管理人计算应收取业绩报酬的每笔集合计划份额在持有期间的年化收益率（R），对超出业绩报酬计提基准的持有期差额收益按【60%】比例计提为业绩报酬。\n" +
                "持有期间的年化收益率R计算如下:\n" +
                "A为本业绩报酬计提基准日的累计单位净值;\n" +
                "B为该笔份额上一个业绩报酬计提基准日的累计单位净值（若上一个业绩报酬计提基准日不存在，推广期参与的为本集合计划成立日，存续期参与的为参与申请日）; \n" +
                "B’为该笔份额上一个业绩报酬计提基准日的单位净值（若上一个业绩报酬计提基准日不存在，推广期参与的为本集合计划成立日，存续期参与的为参与申请日）; \n" +
                "T表示该笔份额在每个运作周期的持有期天数；\n" +
                "本集合计划每个运作周期的业绩报酬计提基准会有所不同，第i个运作周期业绩报酬计提基准（$r_i$）会在该运作周期开始的开放日前在管理人网站公布。当R＞ri时,管理人提取R大于ri的剩余收益部分的60%作为业绩报酬；当R≤ri 时，管理人不提取业绩报酬。\n" +
                "其中：\n" +
                "H为该笔份额在本次业绩报酬计提日应计提的业绩报酬\n" +
                "M=该笔份额数×该笔份额上一个业绩报酬计提基准日的单位净值（若上一个业绩报酬计提基准日不存在，推广期参与的为本集合计划成立日，存续期参与的为参与申请日）;   \n" +
                "T表示该笔份额在每个运作周期的持有期天数;\n" +
                "已计提的业绩报酬无回拨机制。业绩报酬的计算保留到小数点后2位，小数点后第3位四舍五入，由此带来的收益和损失归入集合计划资产。\n" +
                "若业绩报酬计提基准日为本集合计划的分红权益登记日，则由管理人按上述方法计算应计提的业绩报酬金额，然后在分红时从分红金额中扣除业绩报酬；当分红金额不足以扣除业绩报酬时，以分红金额为限进行扣除。\n" +
                "若业绩报酬计提基准日为本集合计划的退出日，则由管理人按上述方法计算应计提的业绩报酬金额，在委托人退出时扣除。";
        data.put("math1", math1);
        data.put("math2", "\\[ \\sum_{i=1}^{\\infty} \\frac{1}{n^s} \n" +
                "= \\prod_p \\frac{1}{1 - p^{-s}} \\]");
        data.put("math3", "Product $\\prod_{i=a}^{b} f(i)$ inside text. $\\mathbb{N} \\mathbf{N} \\mathbb{Z} \\mathbf{Z} \\mathbb{D} \\mathbf{D} \\mathbb{Q} \\mathbf{Q} \\mathbb{R} \\mathbf{R} \\mathbb{C} \\mathbf{C}$");
        data.put("math4", "$\\lim_{x\\to\\infty} f(x)$");
        try (InputStream inputStream = LaTeXRenderPolicyTest.class.getResourceAsStream("/math.docx")) {
            XWPFTemplate.compile(inputStream, configure).render(data).writeToFile("latex_out.docx");
        }
    }
}