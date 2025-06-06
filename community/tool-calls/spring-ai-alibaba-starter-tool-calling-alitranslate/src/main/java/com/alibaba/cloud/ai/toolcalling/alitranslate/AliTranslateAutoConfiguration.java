/*
 * Copyright 2024-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.cloud.ai.toolcalling.alitranslate;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * @author yunlong
 */
@Configuration
@ConditionalOnClass(AliTranslateService.class)
@EnableConfigurationProperties(AliTranslateProperties.class)
@ConditionalOnProperty(prefix = AliTranslateProperties.PREFIX, name = "enabled", havingValue = "true")
public class AliTranslateAutoConfiguration {

	@Bean(destroyMethod = "close")
	@ConditionalOnMissingBean
	@Description("Implement natural language translation capabilities.")
	public AliTranslateService aliTranslateService(AliTranslateProperties properties) {
		return new AliTranslateService(properties);
	}

}
