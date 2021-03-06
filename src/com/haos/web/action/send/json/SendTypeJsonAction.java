package com.haos.web.action.send.json;

import com.haos.common.util.action.BaseAction;
import com.haos.common.util.page.ResultCollection;
import com.haos.domain.send.SendType;
import com.haos.service.send.SendTypeService;

/**
 * Send Type JsonAction
 * @author WangYue
 *
 */
public class SendTypeJsonAction extends BaseAction {
   // private final static Log logger = LogFactory.getLog(SendTypeJsonAction.class);
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Send type information service interface
     */
    private SendTypeService sendTypeService;
    
    /**
     * json result
     */
    private String result;
    
    /**
     * result msg
     */
    private String resultMsg;
    
    /**
     * Send type information value class
     */
    private SendType sendType;


    /**
     * ids array
     */
    private Long[]ids;
    
    /**
     * Add send type method
     *
     * @return
     */
    public String addSendType() {
        if (null != sendType) {

            ResultCollection serviceResult = sendTypeService.addSendType(sendType);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
                result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * Update send type method
     *
     * @return
     */
    public String updateSendType() {
        if (null != sendType) {

            ResultCollection serviceResult = sendTypeService.updateSendType(sendType);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
            	 result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }

    /**
     * delete send type method
     *
     * @return
     */
    public String deleteSendType() {
        if (null != sendType.getId() && sendType.getId().intValue() > 0) {
            ResultCollection serviceResult = sendTypeService.deleteSendTypeById(sendType.getId());
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
            	 result = "false*" + (String) serviceResult.get("resultMsg");
            }
        } else {
            result = "false";
        }
        return "out";
    }
    
    /**
     * Delete send types method
     *
     * @return
     */
    public String deleteSendTypes() {
        if(ids!=null&&ids.length>1){
            ResultCollection serviceResult = sendTypeService.deleteSendTypeByIds(ids);
            
            if (null != serviceResult && serviceResult.getSuccess() && (Boolean) serviceResult.get("resultFlag")) {
                result = "true";
            } else {
            	 result = "false*" + (String) serviceResult.get("resultMsg");
            }
        }else {
            result = "false";
        }
        return "out";
    }
    
    
    /**
     * Check send type code
     *
     * @return
     */
    public String checkSendTypeCode() {
        if (null != sendType) {

            ResultCollection serviceResult = sendTypeService.getSendTypeBySendTypeCode(sendType.getSendTypeCode());
            
            if (null != serviceResult && serviceResult.getSuccess()) {
            	SendType sendType=(SendType)serviceResult.get("sendType");
            	if(sendType!=null&&sendType.getSendTypeCode()!=null){
            		result = "exist";
            	}else{
            		result = "ok";
            	}
            } else {
            	result = "ok";
            }
        } 
        return "out";
    }


    public void setSendTypeService(SendTypeService sendTypeService) {
        this.sendTypeService = sendTypeService;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

	public SendType getSendType() {
		return sendType;
	}

	public void setSendType(SendType sendType) {
		this.sendType = sendType;
	}

	public SendTypeService getSendTypeService() {
		return sendTypeService;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
  
}
