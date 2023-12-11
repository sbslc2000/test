package goorm.stomp;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    private ConcurrentHashMap<String, Container> containers;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        containers = new ConcurrentHashMap<>();
    }

    public void addContainer(Container container) {
        containers.put(container.getContainerId(), container);
    }

    public void removeContainer(String containerId) {
        containers.remove(containerId);
    }

    public List<Container> getContainers() {
        return new ArrayList<>(containers.values());
    }

    public Container getContainer(String containerId) {
        return containers.get(containerId);
    }


}
