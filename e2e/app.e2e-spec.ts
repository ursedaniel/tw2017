import { AcaRPage } from './app.po';

describe('aca-r App', function() {
  let page: AcaRPage;

  beforeEach(() => {
    page = new AcaRPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
