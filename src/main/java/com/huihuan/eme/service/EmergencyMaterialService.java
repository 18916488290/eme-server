package com.huihuan.eme.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.huihuan.eme.domain.db.EmergencyMaterial;
import com.huihuan.eme.domain.page.AuditSatusEnum;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月5日 下午10:10:42
 *
 */
public interface EmergencyMaterialService {

	 public void loadEmergencyMaterials(InputStream inputStream) throws IOException;

	 public List<EmergencyMaterial> getMaterialsByStatus(AuditSatusEnum AuditSatusEnum);

}
