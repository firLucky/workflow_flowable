package com.fir.flow.common.monitor;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.event.impl.FlowableEntityEventImpl;
import org.flowable.engine.delegate.event.AbstractFlowableEngineEventListener;
import org.flowable.engine.delegate.event.FlowableProcessStartedEvent;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.springframework.stereotype.Component;
import java.util.Date;


/**
 * 全局的流程启动的监听器
 *
 * @author fir
 * @date 2022-06-21
 */
@Slf4j
@Component
public class GlobalProcessStartedListener extends AbstractFlowableEngineEventListener {

    @Override
    protected void processStarted(FlowableProcessStartedEvent event) {
        log.info("进入流程开始监听器------------------------Start---------------------->");

        String eventName = event.getType().name();

        FlowableEntityEventImpl flowableEntityEvent = (FlowableEntityEventImpl) event;
        ExecutionEntityImpl processInstance = (ExecutionEntityImpl) flowableEntityEvent.getEntity();

        Date startTime = processInstance.getStartTime();
        String processDefinitionKey = processInstance.getProcessDefinitionKey();
        String processInstanceId = processInstance.getProcessInstanceId();
        String processInstanceBusinessKey = processInstance.getProcessInstanceBusinessKey();
        int suspensionState = processInstance.getSuspensionState();

        log.info("流程事件类型->{}", eventName);
        log.info("流程开始时间->{}", startTime);
        log.info("流程定义Key->{}", processDefinitionKey);
        log.info("流程实例ID->{}", processInstanceId);
        log.info("流程业务key->{}", processInstanceBusinessKey);
        log.info("流程是否挂起标志->{}", suspensionState);

        log.info("流程开始监听器------------------------End---------------------->");

    }
}

