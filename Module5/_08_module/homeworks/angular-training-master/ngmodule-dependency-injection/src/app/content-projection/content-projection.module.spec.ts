import { ContentProjectionModule } from './content-projection.module';

describe('ContentProjectionModule', () => {
  let contentProjectionModule: ContentProjectionModule;

  beforeEach(() => {
    contentProjectionModule = new ContentProjectionModule();
  });

  it('should create an instance', () => {
    expect(contentProjectionModule).toBeTruthy();
  });
});
