package tech.buildrun.magalums.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import tech.buildrun.magalums.entity.Channel;
import tech.buildrun.magalums.entity.Status;
import tech.buildrun.magalums.repository.ChannelRepository;
import tech.buildrun.magalums.repository.StatusRepository;

@Configuration
public class DataLoader {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private StatusRepository statusRepository;


    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }
}
