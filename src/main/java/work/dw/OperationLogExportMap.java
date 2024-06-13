package work.dw;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;

/**
 * @description:
 * @author: zhangyabo
 * @date: 28/12/2023 1:54 pm
 */
public class OperationLogExportMap {

    public static void main(String[] args) {
        System.out.println("3PL线路配置 =》 模块编码/方法名：pageExportThreePlPushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(threePlConfigHeaderMap));
        System.out.println("========================");

        System.out.println("四级地址规则维护（发到买家） =》 模块编码/方法名：pageExportFourAddressToBuyerPushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(FOUR_ADDRESS_HEADER));
        System.out.println("========================");

        System.out.println("三级地址规则维护（发到买家） =》 模块编码/方法名：pageExportThreeAddressToBuyerPushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(THREE_LEVEL_ADDRESS_P2B_HEADER));
        System.out.println("========================");

        System.out.println("入库班次配置 =》 模块编码/方法名：pageExportInboundPushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(INBOUND_HEADER));
        System.out.println("========================");

        System.out.println("中转班次配置 =》 模块编码/方法名：pageExportTransferPushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(TRANSFER_HEADER));
        System.out.println("========================");

        System.out.println("出库班次配置 =》 模块编码/方法名：pageExportOutboundPushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(OUTBOUND_HEADER));
        System.out.println("========================");

        System.out.println("商家班次配置 =》 模块编码/方法名：pageExportMerchantWavePushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println(JSON.toJSONString(MERCHANT_WAVE_HEADER));
        System.out.println("========================");

        System.out.println("时效规则维护 =》 模块编码/方法名：pageExportPromiseRulePushInfo =》 API路径：com.shizhuang.duapp.scp.md.admin.api.client.OperateLogInfoExportApi");
        System.out.println("批量导入：importAgingPath 导入删除：batchDeleteStatusAgingPath");
        System.out.println(JSON.toJSONString(PROMISE_RULE_HEADER));


        System.out.println("========");
        System.out.println("导入MQ配置" + "threePlLineImportV2 ||  importToRemove3plLineV2 || dewuLineImport || scp-master-data-admin-interfaces-import-address-rule-from-platform || scp-master-data-admin-interfaces-import-address-rule-to-platform || scp-master-data-admin-interfaces-import-four-address-rule-from-platformV2 || scp-master-data-admin-interfaces-import-rk-node-wave || scp-master-data-admin-interfaces-import-zz-node-wave || scp-master-data-admin-interfaces-import-ck-node-wave || scp-master-data-admin-interfaces-import-remove-node-wave || importAgingPath || batchDeleteStatusAgingPath || sopMerchantWaveImport || sopMerchantWaveBatchDelete");
        System.out.println("导出MQ配置" + "pageExportThreePlPushInfo || pageExportThreeAddressToBuyerPushInfo || pageExportThreeAddressSendPushInfo || pageExportFourAddressToBuyerPushInfo || pageExportInboundPushInfo || pageExportTransferPushInfo || pageExportOutboundPushInfo || pageExportDwLinePushInfo || pageExportMerchantWavePushInfo || pageExportPromiseRulePushInfo");
    }

    // 3PL
    private static final LinkedHashMap<String, String> threePlConfigHeaderMap = new LinkedHashMap<String, String>(){
        {
            put("oldLine3plTypeName", "线路类型");
            put("oldFromCityName", "始发城市");
            put("oldMapFromWarehouseName", "映射始发仓");
            put("oldToProvinceName", "目的地省份");
            put("oldToCityName", "目的地城市");
            put("oldToRegionName", "目的地区/县");
            put("oldMapToWarehouseName", "映射目的仓");
            put("oldProductStr", "产品");
            put("oldCarrierName", "承运商");
            put("oldServiceProductName", "运输产品");
            put("oldOrderDeadlineTime", "截单时间");
            put("oldPromiseDuration", "承诺时效(天)");
            put("oldFinalSortingStartTime", "末分拣发车时间");
            put("oldFinalSortingOnwayDuration", "末分拣到仓在途时间（小时）");

            put("effectResult", "生效结果");

            put("line3plTypeName", "线路类型");
            put("fromCityName", "始发城市");
            put("mapFromWarehouseName", "映射始发仓");
            put("toProvinceName", "目的地省份");
            put("toCityName", "目的地城市");
            put("toRegionName", "目的地区/县");
            put("mapToWarehouseName", "映射目的仓");
            put("productStr", "产品");
            put("carrierName", "承运商");
            put("serviceProductName", "运输产品");
            put("orderDeadlineTime", "截单时间");
            put("promiseDuration", "承诺时效(天)");
            put("finalSortingStartTime", "末分拣发车时间");
            put("finalSortingOnwayDuration", "末分拣到仓在途时间（小时）");
        }
    };

    // 四级地址（发到买家）
    public static final LinkedHashMap<String, String> FOUR_ADDRESS_HEADER = new LinkedHashMap<String, String>(){
        {
            put("oldFromCityName", "始发城市");
            put("oldMapFromWarehouseName", "映射始发仓");
            put("oldToProvinceName", "目的地省份");
            put("oldToCityName", "目的地城市");
            put("oldToRegionName", "目的地区/县");
            put("oldToTownName", "目的地街道/乡镇");
            put("oldCarrierName", "承运商");
            put("oldServiceProductName", "运输产品");
            put("oldProductStr", "产品");
            put("oldThirdPlDeadlineArrivePortTime", "3PL截止入港时间");
            put("oldThirdPlSignedTime", "3PL妥投时间");

            put("effectResult", "生效结果");

            put("fromCityName", "始发城市");
            put("mapFromWarehouseName", "映射始发仓");
            put("toProvinceName", "目的地省份");
            put("toCityName", "目的地城市");
            put("toRegionName", "目的地区/县");
            put("toTownName", "目的地街道/乡镇");
            put("carrierName", "承运商");
            put("serviceProductName", "运输产品");
            put("productStr", "产品");
            put("thirdPlDeadlineArrivePortTime", "3PL截止入港时间");
            put("thirdPlSignedTime", "3PL妥投时间");
        }
    };

    // 三级地址（发到买家）
    public static final LinkedHashMap<String, String> THREE_LEVEL_ADDRESS_P2B_HEADER = new LinkedHashMap<String, String>(){
        {
            put("oldToProvinceName", "目的地省份");
            put("oldToCityName", "目的地城市");
            put("oldToRegionName", "目的地区/县");
            put("oldProductStr", "产品");
            put("oldThirdPlDeadlineArrivePortTime", "3PL截止入港时间");
            put("oldThirdPlSignedTime", "3PL妥投时间");

            put("effectResult", "生效结果");

            put("toProvinceName", "目的地省份");
            put("toCityName", "目的地城市");
            put("toRegionName", "目的地区/县");
            put("productStr", "产品");
            put("thirdPlDeadlineArrivePortTime", "3PL截止入港时间");
            put("thirdPlSignedTime", "3PL妥投时间");
        }
    };

    // 入库班次
    private static final LinkedHashMap<String, String> INBOUND_HEADER = new LinkedHashMap<String, String>(){
        {
            put("oldWarehouseCode", "仓库编码");
            put("oldProductCode", "产品编码");
            put("oldNodeWaveStartTime", "班次开始时间");
            put("oldNodeWaveEndTime", "班次结束时间");
            put("oldNoHasIdentificationLatestTime", "最晚到车时间");
            put("oldInWarehouseFinishTime", "最晚上架时间");
            put("oldEffectiveDate", "班次生效日期");
            put("oldExpireDate", "班次失效日期");

            put("effectResult", "生效结果");

            put("warehouseCode", "仓库编码");
            put("productCode", "产品编码");
            put("nodeWaveStartTime", "班次开始时间");
            put("nodeWaveEndTime", "班次结束时间");
            put("noHasIdentificationLatestTime", "最晚到车时间");
            put("inWarehouseFinishTime", "最晚上架时间");
            put("effectiveDate", "班次生效日期");
            put("expireDate", "班次失效日期");
        }
    };

    // 中转班次
    private static final LinkedHashMap<String, String> TRANSFER_HEADER = new LinkedHashMap<String, String>(){
        {
            put("oldWarehouseCode", "仓库编码");
            put("oldProductCode", "产品编码");
            put("oldShippingMarkName", "配送类型");
            put("oldCarrierName", "承运商");
            put("oldNodeWaveStartTime", "班次开始时间");
            put("oldNodeWaveEndTime", "班次结束时间");
            put("oldHasIdentificationLatestTime", "有鉴最晚到车时间");
            put("oldSortingLengthTime", "分拣时长");
            put("oldQcLengthTime", "质拍时长");
            put("oldIdentificationLengthTime", "鉴别时长");
            put("oldRecheckLengthTime", "防伪复检时长");
            put("oldOutboundLengthTime", "出库时长");
            put("oldEffectiveDate", "班次生效日期");
            put("oldExpireDate", "班次失效日期");
            put("oldLatestOutWarehouseTime", "最晚出库时间");

            put("effectResult", "生效结果");

            put("warehouseCode", "仓库编码");
            put("productCode", "产品编码");
            put("shippingMarkName", "配送类型");
            put("carrierName", "承运商");
            put("nodeWaveStartTime", "班次开始时间");
            put("nodeWaveEndTime", "班次结束时间");
            put("hasIdentificationLatestTime", "有鉴最晚到车时间");
            put("sortingLengthTime", "分拣时长");
            put("qcLengthTime", "质拍时长");
            put("identificationLengthTime", "鉴别时长");
            put("recheckLengthTime", "防伪复检时长");
            put("outboundLengthTime", "出库时长");
            put("effectiveDate", "班次生效日期");
            put("expireDate", "班次失效日期");
            put("latestOutWarehouseTime", "最晚出库时间");
        }
    };

    // 出库班次
    private static final LinkedHashMap<String, String> OUTBOUND_HEADER = new LinkedHashMap<String, String>(){
        {
            put("oldWarehouseCode", "仓库编码");
            put("oldProductCode", "产品编码");
            put("oldShippingMarkName", "配送类型");
            put("oldCarrierName", "承运商");
            put("oldCarrierAddress", "配载");
            put("oldExecutionCycleName", "执行周期");
            put("oldNodeWaveStartTime", "班次开始时间");
            put("oldNodeWaveEndTime", "班次结束时间");
            put("oldOrderDeadlineTime", "截单时间");
            put("oldEffectiveDate", "班次生效日期");
            put("oldExpireDate", "班次失效日期");
            put("oldLatestOutWarehouseTime", "最晚出库时间");

            put("effectResult", "生效结果");

            put("warehouseCode", "仓库编码");
            put("productCode", "产品编码");
            put("shippingMarkName", "配送类型");
            put("carrierName", "承运商");
            put("carrierAddress", "配载");
            put("executionCycleName", "执行周期");
            put("nodeWaveStartTime", "班次开始时间");
            put("nodeWaveEndTime", "班次结束时间");
            put("orderDeadlineTime", "截单时间");
            put("effectiveDate", "班次生效日期");
            put("expireDate", "班次失效日期");
            put("latestOutWarehouseTime", "最晚出库时间");
        }
    };

    // 商家班次
    private static final LinkedHashMap<String, String> MERCHANT_WAVE_HEADER = new LinkedHashMap<String, String>() {
        {
            put("oldMerchantId", "UserID");
            put("oldMerchantType", "商家类型");
            put("oldCarrierName", "承运商");
            put("oldWarehouseCode", "仓库编码");
            put("oldOrderDeadlineTime", "截单时间");
            put("oldLatestOutWarehouseTime", "最晚发货时间");
            put("oldArriveWarehouseTime", "到仓时间");

            put("effectResult", "生效结果");

            put("merchantId", "UserID");
            put("merchantType", "商家类型");
            put("carrierName", "承运商");
            put("warehouseCode", "仓库编码");
            put("orderDeadlineTime", "截单时间");
            put("latestOutWarehouseTime", "最晚发货时间");
            put("arriveWarehouseTime", "到仓时间");
        }
    };

    // 时效规则
    private static final LinkedHashMap<String, String> PROMISE_RULE_HEADER = new LinkedHashMap<String, String>() {
        {
            put("oldLineTypeName", "线路类型");
            put("oldProductCode", "产品编码");
            put("oldFromCityName", "始发城市");
            put("oldToCityName", "目的地城市");
            put("oldPromiseDuration", "承诺时效（天）");

            put("effectResult", "生效结果");

            put("lineTypeName", "线路类型");
            put("productCode", "产品编码");
            put("fromCityName", "始发城市");
            put("toCityName", "目的地城市");
            put("promiseDuration", "承诺时效（天）");
        }
    };

}
