package jgb.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author jgb
 * @since 6/15/17 12:05 PM
 */
@Configuration
public class ElasticsearchClientConfiguration {
    @Bean(destroyMethod = "close")
    TransportClient transportClient() throws UnknownHostException {
        return new PreBuiltTransportClient(
                Settings.builder()
                        .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), "es-catalog")
                        .build())
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
    }
}
