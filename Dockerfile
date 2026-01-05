# Elasticsearch 9.2.2 이미지 기반
# analysis-nori 플러그인 설치 (한국어 형태소 분석기)
FROM elasticsearch:9.2.2
RUN bin/elasticsearch-plugin install analysis-nori