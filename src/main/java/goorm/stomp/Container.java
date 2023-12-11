package goorm.stomp;

import lombok.Getter;

@Getter
public class Container {

    String containerId;
    String containerName;

    public Container(String containerId, String containerName) {
        this.containerId = containerId;
        this.containerName = containerName;
    }
}
