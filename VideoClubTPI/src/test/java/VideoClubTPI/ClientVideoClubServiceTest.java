/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VideoClubTPI;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Chris Oliva
 */
public class ClientVideoClubServiceTest extends TestCase {
    
    private IVideoClubService remoteVideoClubServiceMock;
    private IVideo Video28Mock;

    @Before
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Video28Mock = EasyMock.createMock(IVideo.class);
        remoteVideoClubServiceMock
                = EasyMock.createMock(IVideoClubService.class);
    }

    @Test
    public void testGetVideo() throws Exception {
        EasyMock.expect(remoteVideoClubServiceMock.getVideo(28))
                .andReturn(Video28Mock);
        EasyMock.replay(remoteVideoClubServiceMock);
        IVideoClubService clientVideoClubService
                = new ClientVideoClubService(remoteVideoClubServiceMock);
        IVideo result = clientVideoClubService.getVideo(28);
        assertEquals(Video28Mock, result);
        EasyMock.verify(remoteVideoClubServiceMock);
    }

    @Test
    public void testClientVideoClubService() {
        try {
            new ClientVideoClubService(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
        new ClientVideoClubService(remoteVideoClubServiceMock);
    }
    
}
